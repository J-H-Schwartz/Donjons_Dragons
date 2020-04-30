package main;

/**
 * Shield object Data class.
 * 
 */
public class Shield {

	/** Shield object name */
	private String name;

	/** Shield object effect */
	private int block;

	public Shield() {
		this("Wooden Shield", 1);
	}

	public Shield(String name_arg, int damage_arg) {
		name = name_arg;
		block = damage_arg;
	}

	public void setName(String new_name) {
		this.name = new_name;
	}

	public String getName() {
		return this.name;
	}

	public void setBlock(int new_block) {
		this.block = new_block;
	}

	public int getBlock() {
		return this.block;
	}
}
