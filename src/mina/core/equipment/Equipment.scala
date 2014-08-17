package mina.core.Equipment

import mina.core.session.IoSession
import scala.actors.Actor

/**
 * Created by Administrator on 2014/8/16.
 */
class Equipment(session:IoSession) extends Actor {
  val attrib = Map[String, Any]()

  def act() {
    var work = true
    while (work) {
      receive {
        // 接受消息, 或者用receiveWith(1000)
        case msg: String => println("a1: " + msg)
        case x: Int => work = false; println("a1 stop: " + x)
      }
    }
  }
}
object Equipment {
  def apply(session: IoSession) = {
    val result = new Equipment(session);
    session.equipment = result
    result.start
    result
  }
}