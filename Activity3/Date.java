package week3;

	public class Date implements Comparable<Date> {
		 
		private int month;
		private int day;
		private int year;

		public Date() {
			month = 1;
			day = 1;
			year = 1;
		}
		
		public Date(int M, int D, int Y) {
			month = M;
			day = D;
			year = Y;
		}
		
		public Date(String M, int D, int Y) {
			year = Y;
			day = D;
			if(M.equalsIgnoreCase("January"))
				month = 1;
			else if (M.equalsIgnoreCase("February"))
				month = 2;
			else if(M.equalsIgnoreCase("March"))
				month = 3;
			else if(M.equalsIgnoreCase("April"))
				month = 4;
			else if(M.equalsIgnoreCase("May"))
				month = 5;
			else if(M.equalsIgnoreCase("June"))
				month = 6;
			else if(M.equalsIgnoreCase("July"))
				month = 7;
			else if(M.equalsIgnoreCase("August"))
				month = 8;
			else if(M.equalsIgnoreCase("September"))
				month = 9;
			else if(M.equalsIgnoreCase("October"))
				month = 10;
			else if(M.equalsIgnoreCase("November"))
				month = 11;
			else if(M.equalsIgnoreCase("December"))
				month = 12;

				}
		
			private String monthToString (int m) {
			
				String month = "";
			
				switch(m) {
			
				case 1: month = "January";
				break;
			
				case 2: month = "February";
	            break;
			
				case 3: month = "March";
	            break;
			
				case 4: month = "April";
	            break;
			
				case 5: month = "May";
	            break;
			
				case 6: month = "June";
	            break;
			
				case 7: month = "July";
	            break;
			
				case 8: month = "August";
	            break;
			
				case 9: month = "September";
	            break;
			
				case 10: month = "October";
	            break;
			
				case 11: month = "November";
	            break;
			
				case 12: month = "December";
	            break;
		
		}
		return month;
	}

		@Override
		public String toString() {
			return this.monthToString(this.month) + " " + this.day + ", " + this.year;
		}

		@Override
		public int compareTo(Date d) {
			
			int check = 0;  // default to equality
			
			if (year != d.year) {
				check = year - d.year;
			}
			else if (month != d.month) {
				check = month - d.month;
			}
			else {
				check = day - d.day;
			}
			return check;
		}
		
	}
