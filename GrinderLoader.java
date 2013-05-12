package mods.simwir.puremetals;

import mods.simwir.puremetals.blocks.BlockGrinder;

public class GrinderLoader extends BlockGrinder{

	protected GrinderLoader(int par1, boolean par2) {
		super(par1, par2);
		/**
		 * Used to load BlockGrinder.java is needed because BlockGrinders constructor is protected.
		 * Might not be nesseary but at of this monent it is.
		 */
	}
}
