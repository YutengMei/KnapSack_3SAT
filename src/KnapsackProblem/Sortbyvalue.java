package KnapsackProblem;
import java.util.Comparator;
/*
 * Comparator for sorting array list.
 */
public class Sortbyvalue implements Comparator<Item>{

		@Override
		public int compare(Item item1, Item item2) {
			return item1.getValues() > item2.getValues() ? -1 :(item1.getValues() < item2.getValues() ? 1 : 0);		
		}
		
	}
