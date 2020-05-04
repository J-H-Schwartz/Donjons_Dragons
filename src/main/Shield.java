package main;

/**
 * Shield object Data class.
 * 
 */
public class Shield implements ShieldClassInterface {

	/** Shield object name */
	private String name;

	/** Shield object effect */
	private int block;

	public Shield() {
		this("Wooden Shield", 1);
	}

	public Shield(String nameArg, int damageArg) {
		name = nameArg;
		block = damageArg;
	}

	@Override
	public void setName(String newName) {
		this.name = newName;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setBlock(int newBlock) {
		this.block = newBlock;
	}

	@Override
	public int getBlock() {
		return this.block;
	}
}
