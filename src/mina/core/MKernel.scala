package mina.core

/**
 * Created by Administrator on 2014/8/18.
 */
class MKernel(val protocol:MProtocol) {
  var equipments = Map[String, MEquipment]()

  def sendMessage(message: MMessage): Unit = {
    equipments.foreach(equ => equ._2 ! message)
  }

  def apply(id: String): MEquipment = {
    if (!equipments.contains(id)) equipments += (id -> MEquipment(id, protocol))
    equipments(id);
  }
}

object MKernel {
  def apply[req <: MRequest](pro: MProtocol): MKernel = {
    new MKernel(pro)//.start().asInstanceOf[MKernel]
  }
}
