package lol.bai.megane.module.fabrictransfer.provider;

import lol.bai.megane.api.provider.FluidInfoProvider;
import net.fabricmc.fabric.api.transfer.v1.client.fluid.FluidVariantRenderHandler;
import net.fabricmc.fabric.api.transfer.v1.client.fluid.FluidVariantRendering;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.minecraft.fluid.Fluid;
import net.minecraft.text.Text;

@SuppressWarnings("UnstableApiUsage")
public class FabricFluidInfoProvider extends FluidInfoProvider<Fluid> {

    FluidVariantRenderHandler handler;

    @Override
    protected void init() {
        handler = FluidVariantRendering.getHandler(getObject());
    }

    @Override
    public boolean hasFluidInfo() {
        return handler != null;
    }

    @Override
    public int getColor() {
        return handler.getColor(FluidVariant.of(getObject()), getWorld(), getPos());
    }

    @Override
    public Text getName() {
        return handler.getName(FluidVariant.of(getObject()));
    }

}
