public class Classroom
{
	static int nextRoom=101;
	int room,capacity;
	static Classroom highest;

	public Classroom(int c)
	{
		room=nextRoom++;
		if(c>highest.capacity)
		{
			highest=this;
		}
		capacity=c;
	}
	
	public static int getNumberOfClassrooms()
	{
		return nextRoom-101;
	}
	
	public int getCapacity()
	{
		return capacity;
	}

	public int getClassroomNumber()
	{
		return room;		
	}

	public static Classroom getMaxCapacityClassroom()
	{
		return highest;
	}

	public String toString()
	{
		return "Classroom: "+room+"/nCapacity: "+capacity;
	}
}