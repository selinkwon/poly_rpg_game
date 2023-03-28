package poly_rpg;

import java.util.ArrayList;


public class Store {
	private ArrayList<Item> itemList = new ArrayList<>();
	private UserManager user = new UserManager();
	private Player player = new Player(user.log);
	
	public Store() {
		Item temp = new Item();
		temp.setKind(Item.WEAPON);
		temp.setName("몽둥이");
		temp.setPower(3);
		temp.setPrice(1000);
		this.itemList.add(temp);

		temp = new Item();
		temp.setKind(Item.WEAPON);
		temp.setName("철검");
		temp.setPower(5);
		temp.setPrice(2000);
		itemList.add(temp);

		temp = new Item();
		temp.setKind(Item.WEAPON);
		temp.setName("레이피어");
		temp.setPower(7);
		temp.setPrice(2500);
		itemList.add(temp);

		temp = new Item();
		temp.setKind(Item.ARMOR);
		temp.setName("낡은티셔츠");
		temp.setPower(1);
		temp.setPrice(300);
		itemList.add(temp);

		temp = new Item();
		temp.setKind(Item.ARMOR);
		temp.setName("가죽갑옷");
		temp.setPower(4);
		temp.setPrice(800);
		itemList.add(temp);

		temp = new Item();
		temp.setKind(Item.ARMOR);
		temp.setName("강철갑옷");
		temp.setPower(7);
		temp.setPrice(1500);
		itemList.add(temp);

		temp = new Item();
		temp.setKind(Item.RING);
		temp.setName("은반지");
		temp.setPower(7);
		temp.setPrice(3000);
		itemList.add(temp);

		temp = new Item();
		temp.setKind(Item.RING);
		temp.setName("금반지");
		temp.setPower(17);
		temp.setPrice(6000);
		itemList.add(temp);

		temp = new Item();
		temp.setKind(Item.RING);
		temp.setName("다이아반지");
		temp.setPower(35);
		temp.setPrice(20000);
		itemList.add(temp);
	}

	public void shopMng() {
		while (true) {
			Tool.write("=============== [상점] ===============");
			Tool.write("[1.무기] [2.갑옷] [3.반지] [0.뒤로가기]");
			int selKind = Integer.parseInt(Tool.input());
			if (selKind == 0) {
				GameManager.stage = 1;
				break;
			}
			while (true) {
				if (selKind == Item.WEAPON)
					Tool.write("=========== [무기] ============\n");
				else if (selKind == Item.ARMOR)
					Tool.write("=========== [방어구] ============\n");
				else if (selKind == Item.RING)
					Tool.write("=========== [반지] ============\n");
				printItems(selKind);
				Tool.write("[골드 : " + player.getMoney() + "]\n\n");
				Tool.write("구입할 아이템 번호를 입력하세요.\n[0.뒤로가기]\n");
				int selNum = Integer.parseInt(Tool.input());
				if (selNum == 0)
					break;
				int count = 0;
				for (int i = 0; i < this.itemList.size(); i++) {
					if (this.itemList.get(i).getKind() == selKind) {
						count += 1;
						if (count == selNum) {
							if(player.getMoney()>=this.itemList.get(i).getPrice()) {
								Player.inven.addItem(this.itemList.get(i));
								player.setMoney(player.getMoney()-itemList.get(i).getPrice());
								Tool.write("[" + this.itemList.get(i).getName() + "] 을 구입했습니다.\n");
							}
							else {
								Tool.write("소지하고 있는 골드가 부족합니다.\n");
							}
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							break;
						}
					}
				}
			}
		}
	}

	public void printItems(int kind) {
		int count = 0;
		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).getKind() != kind)
				continue;
			Tool.write("[" + (count + 1) + "번]\n");
			Tool.write("[이름 : " + itemList.get(i).getName() + "]");
			Tool.write("[능력 : " + itemList.get(i).getPower() + "]");
			Tool.write("[가격 : " + itemList.get(i).getPrice() + "]\n\n");
			count += 1;
		}
	}
}
