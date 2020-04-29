package main;

public class Shield {
	private String name;
	private int block;
	
	public Shield() {
		name = "Spark";
		block = 1;
	}
	
	public Shield(String name_arg, int damage_arg) {
		name = name_arg;
		block = damage_arg;
	}
	
	void setName(String new_name) {
		this.name = new_name;
	}
	
	String getName() {
		return this.name;
	}
	
	void setBlock(int new_block) {
		this.block = new_block;
	}
	
	int getBlock() {
		return this.block;
	}
}
