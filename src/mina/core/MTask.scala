package mina.core

/**
 * Created by Administrator on 2014/8/18.
 */
abstract class MTask(val equid:String) {
  def work(): MTask
}
