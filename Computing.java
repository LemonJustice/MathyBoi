
public class Computing {
	int y;
	boolean isLeap;
	int m;
	int d;
	int mDays;
	
	int vand = 0;
	int[] yearHap = new int[99];
	int greatestIndex = 0;
	int leastIndex = 0;
	int lastOccur = 397;
	int curDiff;
	int largeDiff = 0;
	
	String least = "";
	String most = "";
	
	public Computing() {
	}
	
	
	public void loop(){
		for(y = 1; y<=99; y++) {
			if(y%4 == 0) 
				isLeap = true; 
			else 
				isLeap = false;
			for(m = 1; m<=12; m++) {
				if(m%2 == 0) 
					mDays = 30;
				else 
					mDays = 31;
				if(m == 2) {
						if(isLeap)
							mDays = 29;
						else 
							mDays = 28;
						}
				for(d = 1; d<=mDays; d++) {
					if(dxmCheck(d, m, y)) {
						vand++;
						yearHap[(y-1)]++;
						difference(toDays(d, m, y), lastOccur);
						lastOccur = toDays(d,m,y);
					}
				}
			}
		}
		end();
	}
	
	public boolean dxmCheck(int day, int month, int year) {
		if(day * month == year)
			return true;
		else
			return false;
	}
	public int toDays(int day, int month, int year) {
		if(isLeap)
			year *= 365;
		else
			year *= 366;
		month *= mDays;
		return month + year + day;
	}
	
	public void difference(int curr, int last) {
		curDiff = curr - last;
		if(curDiff > largeDiff)
			largeDiff = curDiff;
	}
	
	public void end() {
		System.out.println(vand + " vandalisms happened between 2001 and 2099!");
		for(int i = 0; i <= 98; i++) {
			if(yearHap[greatestIndex] < yearHap[i])
				greatestIndex = i;
		}
		for(int i = 0; i <= 98; i++) {
			if(yearHap[greatestIndex] == yearHap[i])
				most += (2001 + i) + ", ";
		}
		System.out.println(most + " all had " + yearHap[greatestIndex] + " vandalisms, so they tie for the most");
		for(int i = 0; i <= 98; i++) {
			if(yearHap[leastIndex] > yearHap[i])
				leastIndex = i;
		}
		for(int i = 0; i <= 98; i++) {
			if(yearHap[leastIndex] == yearHap[i])
				least += (i + 2001) + ", ";
		}
		System.out.println(least + " all had " + yearHap[leastIndex] + " vandalisms, so they tie for the least!");
		System.out.println("There was a maximum gap of " + largeDiff + " days between vandalism!");
	}
}
