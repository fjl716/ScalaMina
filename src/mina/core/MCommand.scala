package mina.core

/**
 * Created by Administrator on 2014/8/18.
 */
abstract class MCommand(val command:Map[String,Any]) {
  def dataArrive(request: MRequest, equipment: MEquipment): MResponse
}
