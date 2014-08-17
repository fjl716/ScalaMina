package com.taobao.moxing

import java.net.InetSocketAddress
import mina.core.Equipment.Equipment
import mina.core.session.IoSession

import scala.actors.Actor
import actors.Actor, actors.Actor._

object Actor1 extends Actor { // 或者class

  // 实现线程

  def act() {
    react {
      case Int => println("number"); exit
      case _ => println("ok"); exit
    }
  }

}

/**
 * Created by Administrator on 2014/8/16.
 */
object Main {
  def main(args: Array[String]) = {
    //    val a1 = Actor.actor {
    //          var work = true
    //          while(work) {
    //            receive { // 接受消息, 或者用receiveWith(1000)
    //              case msg:String => println("a1: " + msg)
    //              case x:Int => work = false; println("a1 stop: " + x)
    //            }
    //      }
    //    }
    //    a1 ! "hello" // "a1: hello"
    //    a1 ! "world" // "a1: world"
    //    a1 ! -1 // "a1 stop: -1"

    val session = new IoSession;
    val al=Equipment(session);
    al ! "aaa";
    println("error")

    //    val acceptor=new NioSocketAcceptor()
    //    acceptor.getSessionConfig.setReadBufferSize(2048)
    //    acceptor.getSessionConfig.setIdleTime(IdleStatus.BOTH_IDLE,10)
    //    acceptor.getFilterChain.addLast("code",new ProtocolCodecFilter(CmccSipcCodecFactory))
    //    acceptor.setHandler(MyServer)
    //    acceptor.bind(new InetSocketAddress(9988))
    //    while(true){
    //      Thread.sleep(1000)
    //    }
  }
}
