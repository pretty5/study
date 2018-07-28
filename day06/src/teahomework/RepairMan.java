package teahomework;

/*
*@ClassName:RepairMan
 @Description:TODO
 @Author:
 @Date:2018/7/17 9:19 
 @Version:v1.0
*/
public class RepairMan implements Repair {
    @Override
    public void repairTyre(Vehicle vehicle) {
       /* System.out.println("当前轮胎："+vehicle.getTyre());
        System.out.println("正在修理");
        System.out.println("修理成功");*/
        System.out.println("当前轮胎："+vehicle.getTyre()+"当前气压："+vehicle.getTyre().getPa());
        //增加当前车的轮胎的气压
        Tyre tyre = vehicle.getTyre();

        tyre.setPa(tyre.getPa()+1);

        System.out.println("正在修理");
        System.out.println("修理成功,修理后的气压值为："+vehicle.getTyre().getPa());

    }
}
