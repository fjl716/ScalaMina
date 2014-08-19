package mina.core
import scala.actors.Actor
import scala.collection.immutable.Queue

class MEquipment(val id:String,val protocol:MProtocol) extends Actor {
  val attrib = Map[String, Any]()
  val queTask = Queue[MTask]()
  var port: MPort = null
  def act() {
    var state = MSystemMessageType.Run
    var curtask: MTask = null
    while (state != MSystemMessageType.Close) {
      receive {
        case request: MRequest => {
          protocol.workCommand(request, this)
        }
        case task: MTask => if (curtask != null) queTask.enqueue(task) else curtask = task.work()
        case sysmsg: MSysMessage =>
          sysmsg.msgType match {
            case MSystemMessageType.Close => state = MSystemMessageType.Close
            case MSystemMessageType.Pause =>
            case MSystemMessageType.Continue => println(id + "continum")
          }
        case message: MMessage => {
          println("a1: " + message)
        }
        case port: MPort => this.port = port
      }
    }
  }
  def apply(task: MTask): Unit = {
    queTask.enqueue(task)
  }
  override def toString():String = s"Equipment:$id"
}

object MEquipment {
  def apply[req <: MRequest](id: String, protocol: MProtocol): MEquipment = {
    println("Create Equipment [" + id + "]")
    new MEquipment(id, protocol).start.asInstanceOf[MEquipment]
  }
}