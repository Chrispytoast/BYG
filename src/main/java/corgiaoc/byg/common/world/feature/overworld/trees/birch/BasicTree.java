package corgiaoc.byg.common.world.feature.overworld.trees.birch;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.BYGTreeFeatureConfig;
import corgiaoc.byg.common.world.feature.overworld.trees.util.BYGAbstractTreeFeature;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;

import java.util.Random;
import java.util.Set;

public class BasicTree extends BYGAbstractTreeFeature<BYGTreeFeatureConfig> {

    public BasicTree(Codec<BYGTreeFeatureConfig> configIn) {
        super(configIn);
    }

    public boolean generate(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling, BYGTreeFeatureConfig config) {

        int randTreeHeight = rand.nextInt(config.getMaxPossibleHeight()) + config.getMinHeight();
        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();
        if (posY >= 1 && posY + randTreeHeight + 1 < worldIn.getHeight()) {
            if (!isDesiredGroundwDirtTag(worldIn, pos.down(), config)) {
                return false;
            } else if (!this.isAnotherTreeNearby(worldIn, pos, randTreeHeight, 0, isSapling)) {
                return false;
            } else if (!this.doesSaplingHaveSpaceToGrow(worldIn, pos, randTreeHeight, 5, 5, 5, isSapling)) {
                return false;
            } else {
                Direction direction = Direction.Plane.HORIZONTAL.random(rand);
                int randTreeHeight2 = randTreeHeight - rand.nextInt(1);
                int posY1 = 2 - rand.nextInt(1);
                int posX1 = posX;
                int posZ1 = posZ;
                int topTrunkHeight = posY + randTreeHeight - 1;

                for (int buildTrunk = 0; buildTrunk < randTreeHeight; ++buildTrunk) {
                    if (buildTrunk >= randTreeHeight2 && posY1 < 0) {
                        posX1 += direction.getXOffset();
                        posZ1 += direction.getZOffset();
                        ++posY1;
                    }
                    int logplacer = posY + buildTrunk;
                    BlockPos blockpos1 = new BlockPos(posX1, logplacer, posZ1);

                    if (isAir(worldIn, blockpos1)) {
                        placeTrunk(config, rand, changedBlocks, worldIn, blockpos1, boundsIn);
                    }
                }

                int leavePreset = rand.nextInt(4) + 1;

                if (leavePreset == 1) {
                    int leavessquarespos = 2;
                    for (int posXLeafWidth = -leavessquarespos; posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {
                        for (int posZLeafWidthL0 = -leavessquarespos; posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {

                            placeLeaves(config, rand, worldIn, posX1 + posXLeafWidth, topTrunkHeight - 1, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1 + posXLeafWidth, topTrunkHeight - 2, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1 + posXLeafWidth, topTrunkHeight - 3, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);

                            placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);

                            placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1, topTrunkHeight + 1, posZ1 + 1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1, topTrunkHeight + 1, posZ1 - 1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                        }
                    }
                } else if (leavePreset == 2) {
                    int leavessquarespos = 2;
                    for (int posXLeafWidth = -leavessquarespos; posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {
                        for (int posZLeafWidthL0 = -leavessquarespos; posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {

                            placeLeaves(config, rand, worldIn, posX1 + posXLeafWidth, topTrunkHeight - 1, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1 + posXLeafWidth, topTrunkHeight - 2, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);

                            placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);

                            placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1, topTrunkHeight + 1, posZ1 + 1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1, topTrunkHeight + 1, posZ1 - 1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);

                            placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight - 3, posZ1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight - 3, posZ1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1, topTrunkHeight - 3, posZ1 + 1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1, topTrunkHeight - 3, posZ1 - 1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight - 3, posZ1 + 1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight - 3, posZ1 - 1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight - 3, posZ1 + 1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight - 3, posZ1 - 1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1 + 2, topTrunkHeight - 3, posZ1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1 - 2, topTrunkHeight - 3, posZ1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1, topTrunkHeight - 3, posZ1 + 2, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1, topTrunkHeight - 3, posZ1 - 2, boundsIn, changedBlocks);


                        }
                    }
                } else if (leavePreset == 3) {
                    int leavessquarespos = 2;
                    for (int posXLeafWidth = -leavessquarespos; posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
                        for (int posZLeafWidthL0 = -leavessquarespos; posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {

                            placeLeaves(config, rand, worldIn, posX1 + posXLeafWidth, topTrunkHeight - 1, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1 + posXLeafWidth, topTrunkHeight - 2, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);

                            placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);

                            placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1, topTrunkHeight + 1, posZ1 + 1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1, topTrunkHeight + 1, posZ1 - 1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);


                        }
                    }
                } else if (leavePreset == 4) {
                    int leavessquarespos = 2;
                    for (int posXLeafWidth = -leavessquarespos; posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
                        for (int posZLeafWidthL0 = -leavessquarespos; posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {

                            placeLeaves(config, rand, worldIn, posX1 + posXLeafWidth, topTrunkHeight - 1, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1 + posXLeafWidth, topTrunkHeight - 2, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);

                            placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);

                            placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1, topTrunkHeight + 1, posZ1 + 1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1, topTrunkHeight + 1, posZ1 - 1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);

                            placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight - 3, posZ1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight - 3, posZ1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1, topTrunkHeight - 3, posZ1 + 1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1, topTrunkHeight - 3, posZ1 - 1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight - 3, posZ1 + 1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight - 3, posZ1 - 1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight - 3, posZ1 + 1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight - 3, posZ1 - 1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1 + 2, topTrunkHeight - 3, posZ1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1 - 2, topTrunkHeight - 3, posZ1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1, topTrunkHeight - 3, posZ1 + 2, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1, topTrunkHeight - 3, posZ1 - 2, boundsIn, changedBlocks);

                            placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight - 4, posZ1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight - 4, posZ1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1, topTrunkHeight - 4, posZ1 + 1, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1, topTrunkHeight - 4, posZ1 - 1, boundsIn, changedBlocks);
                        }
                    }
                }
            }

            return true;
            //}
        } else {
            return false;
        }
    }


    private void treelog(Set<BlockPos> setlogblock, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (canLogPlaceHere(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, Blocks.BIRCH_LOG.getDefaultState(), boundingBox);
        }

    }


    private void leafs(ISeedReader reader, int x, int y, int z, MutableBoundingBox boundingBox, Set<BlockPos> blockPos) {
        BlockPos blockpos = new BlockPos(x, y, z);
        if (isAir(reader, blockpos)) {
            this.setFinalBlockState(blockPos, reader, blockpos, Blocks.BIRCH_LEAVES.getDefaultState(), boundingBox);
        }

    }
}