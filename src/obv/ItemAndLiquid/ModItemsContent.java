package obv.ItemAndLiquid;

import arc.util.*;
import mindustry.type.*;
import obv.*;

public class ModItemsContent implements ModContentInterface{
    public static ModUtils utils;

    public static Item iron;
    public static Item glass;
    public static Item ionicPhaseFabric;
    public static Item fullMobileBattery;
    public static Item emptyMobileBattery;
    private static final float unitCost = 2f;

    @Override
    public void init(){
        iron = new Item("iron");
        glass = new Item("glass");
        ionicPhaseFabric = new Item("IonicPhaseFabric");
        fullMobileBattery = new Item("fullMobileBattery");
        emptyMobileBattery = new Item("emptyMobileBattery");
    }

    private void setupItemConfig(){
        //所需钻头强度
        iron.hardness = 1;

        //可燃性，大于0.3会燃烧
        fullMobileBattery.flammability = 1;
        emptyMobileBattery.flammability = 1;

        //放射性，与RTG直接相关
        ionicPhaseFabric.radioactivity = 5;

        //花费，实际上指的是每单位物品所带来的制造时间
        iron.cost = 4 * unitCost;
        glass.cost = 5 * unitCost;
        ionicPhaseFabric.cost = 5 * unitCost;
    }

    private void setupItemColorConfig(){
        iron.color = utils.RGBColorSetWitchHTMLMark(0xaeb7ff);
        glass.color = utils.RGBColorSetWitchHTMLMark(0xdcdcff);
        ionicPhaseFabric.color = utils.RGBColorSetWitchHTMLMark(0xffd59e);
        fullMobileBattery.color = utils.RGBColorSetWitchHTMLMark(0xf8c266);
        emptyMobileBattery.color = utils.RGBColorSetWitchHTMLMark(0x9e7113);
    }

    //    @Override
    public void load(){
        Log.info("[UBV-ITEMS]Start init");
        utils = new ModUtils();

        Log.info("[UBV-ITEMS]Adding config");
        setupItemConfig();
        setupItemColorConfig();

        Log.info("[OBV-ITEMS]Done!");
    }

    @Override
    public boolean enable(){
        return true;
    }

}