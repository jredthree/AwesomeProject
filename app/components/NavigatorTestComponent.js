'use strict';


import React,{Component} from 'react';

import {
    View,
    Text,
    TouchableOpacity,
    Alert,
    
} from 'react-native';

import MainComponent from './MainComponent';
import MyButton from '../widget/MyButton';
var { NativeModules } = require('react-native');

 class NavigatorTestComponent extends Component {


    constructor(props) {
        super(props);
        this.state = {};
        
        this.props.navigator.onPress = ()=> this.onBack();
    }

    _pressButton() {
        this.props.navigator.pop();
    }

    onBack(){
         Alert.alert('温馨提醒','确定退出吗?',[
              {text:'取消',onPress:()=>NativeModules.ToastCustomAndroid.show("我是ToastCustomAndroid弹出消息",NativeModules.ToastCustomAndroid.SHORT)},
              {text:'确定',onPress:()=>this.props.navigator.pop()}
              ])
    
}

    render() {
       return (
          

             <MyButton
                 text = "点我跳回去"
                 onPress={()=>{ NativeModules.loginXpg.login("HelloGizwits", "12345678")}}/>


                //  <MyButton
                //  text = "ceshi"
                //  onPress={()=>{ NativeModules.ToastCustomAndroid.measureLayout(
                //      "我是ToastCustomAndroid弹出消息",
                //      NativeModules.ToastCustomAndroid.SHORT,
                //      (msg) => {
                //     console.log(msg);
                //   },
                //    (x, y, width, height) => {
                //     console.log(x + '坐标,' + y + '坐标,' + width + '宽,' + height+'高');
                //   })}
                //  }/>
           
          );
    }
}
export default NavigatorTestComponent;