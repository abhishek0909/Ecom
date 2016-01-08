package com.savi.ecom.convertor;

public interface IConvertor<TOutput,TInput> {
	
	TOutput convert(TInput input) throws Exception;

}
