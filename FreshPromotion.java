package amazo;

import java.util.Arrays;

public class FreshPromotion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] codeList1 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
		String[] shoppingCart1 = { "orange", "apple", "apple", "banana", "orange", "banana" };
		String[][] codeList2 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
		String[] shoppingCart2 = { "banana", "orange", "banana", "apple", "apple" };
		String[][] codeList3 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
		String[] shoppingCart3 = { "apple", "banana", "apple", "banana", "orange", "banana" };
		String[][] codeList4 = { { "apple", "apple" }, { "apple", "apple", "banana" } };
		String[] shoppingCart4 = { "apple", "apple", "apple", "banana" };
		String[][] codeList5 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
		String[] shoppingCart5 = { "orange", "apple", "apple", "banana", "orange", "banana" };
		String[][] codeList6 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
		String[] shoppingCart6 = { "apple", "apple", "orange", "orange", "banana", "apple", "banana", "banana" };
		String[][] codeList7 = { { "anything", "apple" }, { "banana", "anything", "banana" } };
		String[] shoppingCart7 = { "orange", "grapes", "apple", "orange", "orange", "banana", "apple", "banana",
				"banana" };
		String[][] codeList8 = { { "apple", "orange" }, { "orange", "banana", "orange" } };
		String[] shoppingCart8 = { "apple", "orange", "banana", "orange", "orange", "banana", "orange", "grape" };
		String[][] codeList9 = { { "anything", "anything", "anything", "apple" }, { "banana", "anything", "banana" } };
		String[] shoppingCart9 = { "orange", "apple", "banana", "orange", "apple", "orange", "orange", "banana",
				"apple", "banana" };

		// test
		test(codeList1, shoppingCart1, 1);
		test(codeList2, shoppingCart2, 0);
		test(codeList3, shoppingCart3, 0);
		test(codeList4, shoppingCart4, 0);
		test(codeList5, shoppingCart5, 1);
		test(codeList6, shoppingCart6, 1);
		test(codeList7, shoppingCart7, 1);
		test(codeList8, shoppingCart8, 1);
		test(codeList9, shoppingCart9, 1);

	}

	public static void test(String[][] codeList, String[] shoppingCart, int expect) {
		System.out.println(Arrays.toString(shoppingCart));
		System.out.println(check(codeList, shoppingCart)==expect);
	}

	static int check(String[][] codeList, String[] shoppingCart) {
		if (codeList == null || codeList.length == 0)
			return 1;
		if (shoppingCart == null || shoppingCart.length == 0)
			return 0;
		int i = 0, j = 0;
		while (j < codeList.length && i + codeList[j].length <= shoppingCart.length) {

			boolean flag = true;
			for (int k = 0; k < codeList[j].length; k++) {

				if (codeList[j][k].equals(shoppingCart[i + k]) || codeList[j][k].equals("anything")) {
				}else {
					flag = false;
					i++;
					break;
				}

			}
			if (flag) {
				i += codeList[j].length;
				j++;
			}
		}

		System.out.println("value of j" + j + "...value of i " + i);
		return (j == codeList.length) ? 1 : 0;
	}

}
