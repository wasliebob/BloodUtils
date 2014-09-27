package bloodutils.blocks.fluids;

import net.minecraftforge.fluids.Fluid;

public class BUFluid extends Fluid{
	public BUFluid(String fluidName, int density, int viscosity, int color){
		super(fluidName);
		setDensity(density);
		setViscosity(viscosity);
		this.color = color;
	}
	public int color;

    @Override
    public int getColor(){
        return this.color;
    }
}