package controllers;

public class ApplicationController {
    public static void main(String[] args) {
//        создание модели
//                создание контроллера по нобхожимости + передача контроллер
//            сощдание вью, которая принимает контроллер
//                вью.show
        new StudentsController().index();
    }
}
