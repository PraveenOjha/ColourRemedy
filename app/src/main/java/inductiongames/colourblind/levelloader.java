package inductiongames.colourblind;

public class levelloader {
	public static curData level_loader(int n) {
		curData d = new curData();
		d.r = episelector.dat.r[n];
		d.g = episelector.dat.g[n];
		d.b = episelector.dat.b[n];
		return d;

	}

}
