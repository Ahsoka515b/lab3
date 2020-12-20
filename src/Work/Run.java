package Work;

import IO.FileIO;
import Math.MathF;

/**
 * @version 1.0
 * @author Syrovaten Stanislav Seergeevich
 *
 */
public class Run {
	public static void main(String[] args) {
			FileIO fio = new FileIO("9.bin", "1.txt");
			fio.OpenBin();
			
			MathF math = new MathF(fio.Read());
			String res = math.GetResults();
			System.out.println(res);
			fio.SaveFile(res);
		//}
	}
}
