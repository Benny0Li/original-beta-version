package obv;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.meta.BuildVisibility;

public class ModBlocks implements ContentList{
    public static Wall bigIronWall;
    public static Wall smallIronWall;
    private void initWall(){
        bigIronWall=new Wall("bigIronWall");
        smallIronWall=new Wall("smallIronWall");
    }
    private void setupWallConfig(){
        bigIronWall.size=2;
        smallIronWall.size=1;

        bigIronWall.health=3200;
        smallIronWall.health=800;

        bigIronWall.requirements(Category.defense,BuildVisibility.shown,new ItemStack[]{});
        smallIronWall.requirements(Category.defense,BuildVisibility.shown,new ItemStack[]{});

        bigIronWall.buildCostMultiplier=1.25f;
        smallIronWall.buildCostMultiplier=0.8f;
    }
    public void load(){
        initWall();
        setupWallConfig();
    }
}