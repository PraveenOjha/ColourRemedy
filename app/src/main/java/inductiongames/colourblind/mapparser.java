package inductiongames.colourblind;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class mapparser {
	private static final String COMMA = ", ";

	public static Data importObj(InputStream js) throws Exception {

		Data data = new Data();
		ArrayList<tdata> temdata = new ArrayList<tdata>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(js));
		StringTokenizer st;
		String line = reader.readLine();

		while (line != null) {
			st = new StringTokenizer(line, COMMA);
			if (st.countTokens() > 1) {
				String lineType = st.nextToken(COMMA);
				if (lineType.equals("e")) {
					tdata Temdata = new tdata();
					Temdata.episode = Integer.valueOf(st.nextToken());
					Temdata.l = Integer.valueOf(st.nextToken());
					Temdata.r = Integer.valueOf(st.nextToken());
					Temdata.g = Integer.valueOf(st.nextToken());
					Temdata.b = Integer.valueOf(st.nextToken());
					temdata.add(Temdata);
				}

			}
			line = reader.readLine();
		}

		reader.close();

		data.episode = new int[temdata.size()];
		data.level = new int[temdata.size()];
		data.r = new int[temdata.size()];
		data.g = new int[temdata.size()];
		data.b = new int[temdata.size()];

		data.index = temdata.size();
		int i = 0;
		while (i < temdata.size()) {
			data.episode[i] = temdata.get(i).episode;
			data.level[i] = temdata.get(i).l;
			data.r[i] = temdata.get(i).r;
			data.g[i] = temdata.get(i).g;
			data.b[i] = temdata.get(i).b;
			i++;
		}
		return data;
	}

	private static class tdata {

		public int episode;
		public int l;
		public int r;
		public int g;
		public int b;
	}

}
