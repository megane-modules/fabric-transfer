package lol.bai.megane.module.fabrictransfer;

import lol.bai.megane.api.MeganeModule;
import lol.bai.megane.api.registry.CommonRegistrar;
import lol.bai.megane.module.fabrictransfer.provider.FabricCauldronProvider;
import net.minecraft.block.Block;

public class MeganeFabricTransfer implements MeganeModule {

    @Override
    public void registerCommon(CommonRegistrar registrar) {
        registrar.addCauldron(Block.class, new FabricCauldronProvider());
    }

}
