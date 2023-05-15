package com.pen.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.pen.app.bns.mapper.BnsMapper;


@Controller
public class BnsController {

@Autowired BnsMapper dao;
	
	
}
