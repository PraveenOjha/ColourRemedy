package inductiongames.colourblind;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import android.content.Context;

public class Datastore implements Serializable {

	static public String FILENAME = "colorblind_7";
	private static final long serialVersionUID = 1L;
	public int unlocked[] = new int[ViewManager.numberofstage + 3];
	public int per[] = new int[ViewManager.numberofstage];
	public float gameper;
	public int diffiun;

	public int num_un;

	public Datastore() {
		int i = 0;
		while (i < ViewManager.numberofstage) {
			unlocked[i] = 0;
			per[i] = 0;

			i++;
		}
		unlocked[0] = 1;
		unlocked[16] = 1;
		unlocked[32] = 1;
		gameper = 0;
		diffiun = 0;
		num_un = 0;
	}

	public static void save(String SAVENAME, Datastore theObjectAr,
			Context context) {
		try {
			FileOutputStream fos = context.openFileOutput(SAVENAME,
					Context.MODE_PRIVATE);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(theObjectAr);
			oos.close();
			fos.close();
		} catch (IOException e) {
		}

	}

	public static Datastore Load(String SAVENAME, Context context) {
		try {
			FileInputStream is = context.openFileInput(SAVENAME);
			ObjectInputStream ois = new ObjectInputStream(is);
			Datastore f = (Datastore) ois.readObject();
			ois.close();
			is.close();
			return f;
		} catch (IOException e) {
			Del(Datastore.FILENAME, colourremedy.contex);
		} catch (ClassNotFoundException e) {
			Del(Datastore.FILENAME, colourremedy.contex);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void Del(String SAVENAME, Context context) {
		context.deleteFile(SAVENAME);
	}

}
