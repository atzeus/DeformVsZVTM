package test.vszvtm.deformtest

import deform.library.Render._
import deform.library.Transforms._
import deform.library.Transforms.Lens._
import deform.library.Drawings._
import deform.library.Shapes._
import deform.library.Textures._
import deform.library.TexturedShapes._
import deform.library.Colors._
import deform.library.Colors.ColorNames._
import deform._

class LensTest(val zoom : Double) extends MeasureScala{
 var lorem = null : String 
  var atze = null : Shape
 
  var img = null : TexturedShape
  var txt = null : TexturedShape
  var all = null: Drawing
  
  override def init() = {
    lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam sed turpis sed felis vestibulum pretium.\nPraesent at elit vitae odio eleifend tristique in sit amet sem. In cursus condimentum enim eget\nmalesuada. Donec iaculis, velit non tempor egestas, tellus lacus viverra orci, sed ultricies lorem magna"

    atze =  translate((-size.x/2)/(rscale/2),0) ** scale(1/(rscale)) ** text(lorem,60)
    img =  image("landscape.jpg")
    txt = fill(atze,fillColor(black))
      val inner = 100/(rscale/2)
    val outer = 200/(rscale/2)
    val l = lens(circleNorm,linearProfile,Point(0,0), inner, outer, zoom)
    all = l ** drawing(img,txt)
  }

  
  
  def getZoom() = zoom
  def draw(): Unit = {

    draw(all) 
   }
 
  def main(args: Array[String]): Unit = {
    new LensTest(args(0).toDouble)
  }
  
}