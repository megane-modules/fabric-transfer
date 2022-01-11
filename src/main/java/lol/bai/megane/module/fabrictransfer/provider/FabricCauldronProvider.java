package lol.bai.megane.module.fabrictransfer.provider;

import lol.bai.megane.api.provider.CauldronProvider;
import org.jetbrains.annotations.Nullable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.fabricmc.fabric.api.transfer.v1.fluid.CauldronFluidContent;

@SuppressWarnings("UnstableApiUsage")
public class FabricCauldronProvider extends CauldronProvider {

    private CauldronFluidContent content;

    @Override
    public void setContext(World world, BlockPos pos, PlayerEntity player, Void unused) {
        super.setContext(world, pos, player, unused);

        this.content = CauldronFluidContent.getForBlock(getState().getBlock());
    }

    @Override
    public boolean hasFluids() {
        return content != null;
    }

    @Override
    public @Nullable Fluid getFluid(int slot) {
        return content.fluid;
    }

    @Override
    public double getStored(int slot) {
        return droplets(content.currentLevel(getState()) * content.amountPerLevel);
    }

    @Override
    public double getMax(int slot) {
        return droplets(content.maxLevel * content.amountPerLevel);
    }

}
