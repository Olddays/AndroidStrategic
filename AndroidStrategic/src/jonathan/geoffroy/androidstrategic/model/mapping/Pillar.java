package jonathan.geoffroy.androidstrategic.model.mapping;

public class Pillar extends Terrain {
	public Pillar() {
		pedestrianMovementCost = 2;
		riderMovementCost = 1;
		defense = 1;
		avoid = 20;
	}
}
