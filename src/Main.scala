package mina.core
/**
 * Created by Administrator on 2014/8/16.
 */
object Main {

  def main(args: Array[String]) = {
    println("Start")

    val kernel = MKernel(
      //新建通讯规约
      new MProtocol("AFN", "FN") {
        //处理请求数据帧
        override def parseRequest(port: MPort): MRequest = {
          new MRequest("10", Map("AFN" -> 1, "FN" -> 2))
        }

        //打包数据
        override def packResponse(equipment: MEquipment, response: MResponse): Array[Byte] = {
          Array[Byte](100)
        }
      }
    )
    //添加解析命令
    kernel.protocol += new MCommand(Map("AFN" -> 1, "FN" -> 2)) {
      override def dataArrive(request: MRequest, equipment: MEquipment): MResponse = {
        println("work")
        new MResponse(this.command)
      }
    }

    //模拟端口建立
    val port = new MPort(kernel) {
      override def send(data: Array[Byte]): Unit = {
        data.foreach(f => print(f + " "))
        println()
      }
    }

    port.dataArrive()

    kernel.sendMessage(new MSysMessage(MSystemMessageType.Continue))
  }
}
