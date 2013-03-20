/**
 * Created with IntelliJ IDEA.
 * User: xuxiaoming
 * Date: 13-1-9
 * Time: 上午10:25
 * To change this template use File | Settings | File Templates.
 */
$(document).ready(function(){

    $('.carousel').carousel({interval:6000});
    $('.typehead').typehead();


});

function changeSlide(slideNum){

    $('.carousel').carousel('pause');
    $('.carousel').carousel(slideNum);

}