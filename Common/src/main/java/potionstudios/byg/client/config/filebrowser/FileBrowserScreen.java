package potionstudios.byg.client.config.filebrowser;

import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.ContainerObjectSelectionList;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FileBrowserScreen extends Screen {

    public static final Function<Path, List<Path>> CONFIG_FILES = (configDir) -> {
        try {
            return Files.walk(configDir).filter(path -> !path.toFile().isDirectory()).sorted(Comparator.comparing(Path::toString)).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    };

    public static Predicate<Path> RELOADS_ON_SAVE = path -> false;
    public static Consumer<Path> ON_RELOAD = path -> {
    };

    private final Screen parent;
    private final Path configDir;
    private ConfigMap<?> configFiles;
    private String searchCache = "";
    private EditBox searchBox;
    private final Set<KeyCommentToolTipEntry<?>> hidden = new ObjectOpenHashSet<>();

    public FileBrowserScreen(Screen parent, Path configDir, Component component) {
        super(component);
        this.parent = parent;
        this.configDir = configDir;
    }

    @Override
    public void tick() {
        this.configFiles.children().forEach(KeyCommentToolTipEntry::tick);
        this.searchBox.tick();
    }

    @Override
    protected void init() {
        this.configFiles = new ConfigMap<>(this, width, height, 40, this.height - 37, 25);
        int searchWidth = 250;
        this.searchBox = new EditBox(Minecraft.getInstance().font, this.width / 2 - (searchWidth / 2), 18, searchWidth, 20, new TextComponent(""));
        this.searchBox.setResponder(this::searchResponder);
        int maxCommentWidth = this.configFiles.getRowWidth();
        for (Path path : CONFIG_FILES.apply(this.configDir)) {
            String relativizedPath = this.configDir.getParent().relativize(path).toString();
            FileEntry<?> fileEntry = new FileEntry<>(RELOADS_ON_SAVE.test(path), this, relativizedPath, path, ON_RELOAD);
            maxCommentWidth = Math.max(maxCommentWidth, fileEntry.getRowLength());
            this.configFiles.addEntry(fileEntry);
        }
        this.configFiles.rowWidth = maxCommentWidth;

        int buttonWidth = 150;
        this.addRenderableWidget(new Button(this.width - (this.width / 2) - (buttonWidth / 2), this.height - 30, buttonWidth, 20, CommonComponents.GUI_DONE, (p_95761_) -> {
            this.minecraft.setScreen(this.parent);
        }));
        this.addRenderableWidget(this.searchBox);

        this.addWidget(this.configFiles);
        super.init();
    }

    private void searchResponder(String s) {
        if (!this.searchCache.equals(s)) {
            List children = this.configFiles.children();
            ArrayList<? extends KeyCommentToolTipEntry<?>> keyCommentToolTipEntries = new ArrayList<>(children);
            for (KeyCommentToolTipEntry<?> child : keyCommentToolTipEntries) {
                if (!child.key.toLowerCase().contains(s.toLowerCase())) {
                    children.remove(child);
                    child.renderToolTip = false;
                    hidden.add(child);
                }
            }
            for (KeyCommentToolTipEntry<?> entry : new ObjectOpenHashSet<>(this.hidden)) {
                if (entry.key.toLowerCase().contains(s.toLowerCase())) {
                    children.add(entry);
                    this.hidden.remove(entry);
                }
            }
            this.searchCache = s;
            this.configFiles.setScrollAmount(0);
        }
    }


    @Override
    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        this.renderBackground(pPoseStack);
        this.configFiles.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        drawCenteredString(pPoseStack, this.font, this.title, this.width / 2, 5, 16777215);
        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        for (KeyCommentToolTipEntry<?> child : this.configFiles.children()) {
            if (child.renderToolTip) {
                this.renderTooltip(pPoseStack, child.toolTip, Optional.empty(), pMouseX, pMouseY);
            }
        }
    }

    @Override
    public void onClose() {
        this.minecraft.setScreen(this.parent);
    }

    public static class ConfigMap<T> extends ContainerObjectSelectionList<KeyCommentToolTipEntry<T>> {
        private final Screen screen;
        private int rowWidth;

        public ConfigMap(Screen screen, int width, int height, int y0, int y1, int itemHeight) {
            super(Minecraft.getInstance(), width, height, y0, y1, itemHeight);
            this.screen = screen;
            rowWidth = super.getRowWidth();
            this.setRenderBackground(false);
        }

        @Override
        protected boolean isFocused() {
            return this.screen.getFocused() == this;
        }

        @Override
        public int addEntry(KeyCommentToolTipEntry $$0) {
            return super.addEntry($$0);
        }

        @Override
        public int getRowWidth() {
            return this.rowWidth;
        }

        @Override
        protected int getScrollbarPosition() {
            return this.width - 10;
        }
    }
}
