package mina.core
/**
 * Created by Administrator on 2014/8/18.
 */

object MSystemMessageType extends Enumeration {
  type MSystemMessageType = Value
  val Run,Close,Pause,Continue  = Value
}

class MSysMessage(val msgType:MSystemMessageType.MSystemMessageType) extends MMessage(""){

}
