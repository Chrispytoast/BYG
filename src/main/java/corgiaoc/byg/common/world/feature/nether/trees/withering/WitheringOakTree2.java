package corgiaoc.byg.common.world.feature.nether.trees.withering;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.properties.blocks.end.impariusgrove.ImpariusMushroomBranchBlock;
import corgiaoc.byg.common.world.feature.config.BYGTreeConfig;
import corgiaoc.byg.common.world.feature.overworld.trees.util.BYGAbstractTreeFeature;
import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;

import java.util.Random;
import java.util.Set;

public class WitheringOakTree2 extends BYGAbstractTreeFeature<BYGTreeConfig> {

    public WitheringOakTree2(Codec<BYGTreeConfig> configIn) {
        super(configIn);
    }

    protected boolean generate(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling, BYGTreeConfig config) {

        int randTreeHeight = config.getMinHeight() + rand.nextInt(config.getMaxPossibleHeight());
        BlockPos.Mutable mainmutable = new BlockPos.Mutable().set(pos);

        if (pos.getY() + randTreeHeight + 1 < /*worldIn.getHeight() TODO: Use world height in 1.17*/ 128) {
            if (!isDesiredGroundwNetherTags(worldIn, pos.below(), config)) {
                return false;
            } else if (!this.isAnotherTreeNearby(worldIn, pos, randTreeHeight, 0, isSapling)) {
                return false;
            } else if (!this.doesSaplingHaveSpaceToGrow(worldIn, pos, randTreeHeight, 7, 5, 5, isSapling)) {
                return false;
            } else {
                placeNetherTrunk(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 0, 0), boundsIn);
                placeNetherTrunk(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 1, 0), boundsIn);
                placeNetherTrunk(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 2, 0), boundsIn);
                placeNetherTrunk(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 3, 0), boundsIn);
                placeNetherTrunk(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 4, 0), boundsIn);
                placeNetherTrunk(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 5, 0), boundsIn);
                placeNetherTrunk(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 6, 0), boundsIn);
                placeNetherBranch(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 0, 0), boundsIn);
                placeNetherBranch(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 0, -1), boundsIn);
                placeNetherBranch(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 0, 1), boundsIn);
                placeNetherBranch(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 0, 0), boundsIn);
                placeNetherBranch(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 1, -1), boundsIn);
                placeNetherBranch(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 1, 1), boundsIn);
                placeNetherBranch(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 2, -1), boundsIn);
                placeNetherBranch(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 6, -1), boundsIn);
                placeNetherBranch(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 6, 0), boundsIn);
                placeNetherBranch(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 7, -1), boundsIn);
                placeNetherBranch(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, 7, -5), boundsIn);
                placeNetherBranch(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(4, 7, -5), boundsIn);
                placeNetherBranch(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(4, 7, -3), boundsIn);
                placeNetherBranch(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(4, 7, -2), boundsIn);
                placeNetherBranch(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 8, -1), boundsIn);
                placeNetherBranch(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(4, 8, -4), boundsIn);
                placeNetherBranch(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(4, 8, -3), boundsIn);
                placeNetherBranch(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(5, 8, -3), boundsIn);
                placeNetherBranch(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(6, 8, -2), boundsIn);
                placeNetherBranch(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 9, -1), boundsIn);
                placeNetherBranch(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 9, -1), boundsIn);
                placeNetherBranch(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, 9, -3), boundsIn);
                placeNetherBranch(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(4, 9, -3), boundsIn);
                placeNetherBranch(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 10, -2), boundsIn);
                placeNetherBranch(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, 10, -2), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 2, -1), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 3, -1), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 3, 1), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 4, 0), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 4, 0), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, 4, -5), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 5, 0), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 5, -1), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 5, 1), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 5, 0), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, 5, -5), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, 5, -4), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(5, 5, -2), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 6, 1), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 6, -2), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 6, -5), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 6, -4), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 6, -1), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, 6, -6), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, 6, -5), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, 6, -4), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, 6, -2), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, 6, -1), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(4, 6, -5), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(4, 6, -3), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(4, 6, -2), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(5, 6, -3), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(5, 6, -2), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(6, 6, -1), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 7, -2), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 7, 0), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 7, -4), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 7, -2), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 7, 0), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 7, -5), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 7, -1), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 7, 1), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, 7, -6), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, 7, -4), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, 7, -3), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, 7, -2), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(4, 7, -6), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(4, 7, -4), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(4, 7, -1), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(5, 7, -5), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(5, 7, -3), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(5, 7, -1), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(6, 7, -3), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(6, 7, -2), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(6, 7, -1), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(7, 7, -2), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 8, -1), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 8, -4), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 8, -2), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 8, 0), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 8, 1), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 8, -6), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 8, -5), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 8, -4), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 8, -3), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 8, -1), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 8, 0), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 8, 1), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, 8, -5), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, 8, -4), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, 8, -3), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(4, 8, -6), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(4, 8, -5), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(4, 8, -2), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(5, 8, -4), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(5, 8, -2), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(5, 8, -1), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(6, 8, -3), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(6, 8, -1), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(7, 8, -3), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(7, 8, -2), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(7, 8, -1), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 9, -2), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 9, -1), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 9, -5), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 9, -3), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 9, 0), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, 9, -5), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, 9, -4), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, 9, -2), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, 9, -1), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(4, 9, -6), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(4, 9, -5), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(4, 9, -4), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(4, 9, -2), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(5, 9, -5), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(5, 9, -4), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(5, 9, -3), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(6, 9, -4), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(6, 9, -3), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(6, 9, -2), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 10, -2), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 10, -1), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 10, -4), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, 10, -4), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, 10, -3), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, 10, -1), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(4, 10, -4), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(4, 10, -3), boundsIn);
                placeLeaves(pos,config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 11, -2), boundsIn);
                this.ArisianBloomBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 1, -1),boundsIn, Direction.WEST);
                this.ArisianBloomBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 1, -1), boundsIn, Direction.EAST);
                this.ArisianBloomBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 2, -2), boundsIn, Direction.NORTH);
                this.ArisianBloomBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 2, 1), boundsIn, Direction.SOUTH);
                this.ArisianBloomBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 3, 0), boundsIn, Direction.WEST);
                this.ArisianBloomBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 3, 0), boundsIn, Direction.EAST);
                this.ArisianBloomBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 4, 1), boundsIn, Direction.SOUTH);
            }
        }
        return true;
    }
}
