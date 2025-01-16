package 추상_개념2;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<MyBrand> brandList = new ArrayList<>();
		ArrayList<String> brandType = new ArrayList<>();
		brandType.add("MyBakery");
		brandType.add("MyChicken");
		brandType.add("MyCafe");
		
				

		System.out.println(MyBakery.getSlogan());
		
		MyBakery store1 = new MyBakery("구로");
		MyBakery store2 = new MyBakery("강남", true);
		brandList.add(store1);
		brandList.add(store2);
		
		System.out.println(MyChicken.getSlogan());
		
		MyChicken store3 = new MyChicken("홍대");
		MyChicken store4 = new MyChicken("종로");
		brandList.add(store3);
		brandList.add(store4);
		
		
		MyCafe store5 = new MyCafe("건대");
		MyCafe store6 = new MyCafe("잠실");
		MyCafe store7 = new MyCafe("사당",true);
		brandList.add(store5);
		brandList.add(store6);
		brandList.add(store7);
		
		for(String s : brandType) {
			System.out.println("======================================");
			for(MyBrand b : brandList)
				if(b.getClass().getSimpleName().equals(s))
					b.printMyBrandInfo();
		}
		
//		for(MyBrand b : brandList) {
//			if(b instanceof MyBakery)
//				b.takeOrder();
//			if(b instanceof MyChicken)
//				b.takeOrder();
//			if(b instanceof MyCafe)
//				b.takeOrder();
//		}
		System.out.println("======================================");
		
		System.out.println("[ 현재 보유 점포 목록 ]");
		
		for(MyBrand brand : brandList)
			brand.printMyBrandInfo();
		
		System.out.println("======================================");
	}

}
