//package com.example.demo.sortByString;
//
//public class listSortByNanme {
//
//    public static List<PersonBean> listToSortByName(List<PersonBean> list){
//        if(list==null || list.size()==0){
//            return null;
//        }
//        Map<String, PersonBean> map = new HashMap<String, PersonBean>();
//        String names[] = new String[list.size()];
//        for(int i=0;i<list.size();i++){
//            String name = list.get(i).getName();
//            names[i] = name;
//            map.put(name, list.get(i));
//        }
//        names = sort(names);
//        list.clear();
//        for(String name : names){
//            if(map.containsKey(name))
//                list.add(map.get(name));
//        }
//        return list;
//    }
//    public static void main(String[] args) {
//        List<PersonBean> list = new ArrayList<PersonBean>();
//        PersonBean person1 = new PersonBean();
//        person1.setId(1);
//        person1.setName("张三");
//        PersonBean person2 = new PersonBean();
//        person2.setId(2);
//        person2.setName("王二麻子");
//        PersonBean person3 = new PersonBean();
//        person3.setId(3);
//        person3.setName("阿一");
//        PersonBean person4 = new PersonBean();
//        person4.setId(4);
//        person4.setName("田七");
//        list.add(person1);
//        list.add(person2);
//        list.add(person3);
//        list.add(person4);
//        System.out.println("排序前");
//        for(PersonBean person : list){
//            System.out.println(person.getId()+"  "+person.getName());
//        }
//        list = listToSortByName(list);
//        System.out.println("排序后");
//        for(PersonBean person : list){
//            System.out.println(person.getId()+"  "+person.getName());
//        }
//    }
//
//}
//
