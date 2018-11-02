package com.tian.pattern.facade;

/**
 * @auther: lawt
 * @date: 2018/10/29 22
 * @Description: 销售人员==门面
 */
public class SaleMen {

    public void saleRedTea() {
        Water water = new Water();
        water.getWater();//获取水
        Tea tea = new Tea();
        tea.getRedTea();//获取红茶材料
        MakeTea makeTea = new MakeTea();
        makeTea.makeTea();//泡茶
        PackingTea packingTea = new PackingTea();
        packingTea.packingTea();//打包
    }

    public void saleGreenTea() {
        Water water = new Water();
        water.getWater();//获取水
        Tea tea = new Tea();
        tea.getGreenTea();//获取绿茶材料
        MakeTea makeTea = new MakeTea();
        makeTea.makeTea();//泡茶
        PackingTea packingTea = new PackingTea();
        packingTea.packingTea();//打包
    }

    public void saleMilkTea() {
        Water water = new Water();
        water.getWater();//获取水
        Tea tea = new Tea();
        tea.getMilkTea();//获取奶茶材料
        MakeTea makeTea = new MakeTea();
        makeTea.makeTea();//泡茶
        PackingTea packingTea = new PackingTea();
        packingTea.packingTea();//打包
    }
}
