/*
 *
 *      Copyright (c) 2018-2025, xmstir All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 *  this list of conditions and the following disclaimer.
 *  Redistributions in binary form must reproduce the above copyright
 *  notice, this list of conditions and the following disclaimer in the
 *  documentation and/or other materials provided with the distribution.
 *  Neither the name of the pig4cloud.com developer nor the names of its
 *  contributors may be used to endorse or promote products derived from
 *  this software without specific prior written permission.
 *  Author: xmstir
 *
 */

package com.team.ptjs.Api.R;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 响应信息主体
 *
 * @param <T>
 * @author xmstir
 */
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class R<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private int code;

	@Getter
	@Setter
	private String msg;

	@Getter
	@Setter
	private T data;

	public static <T> R<T> ok() {
		return restResult(null, 0, null);
	}

	public static <T> R<T> ok(T data) {
		return restResult(data, 0, null);
	}

	public static <T> R<T> ok(T data, String msg) {
		return restResult(data, 0, msg);
	}

	public static <T> R<T> ok(String msg) { return restResult(null, 0, msg); }


	public static <T> R<T> failed() {
		return restResult(null, 1, null);
	}

	public static <T> R<T> failed(String msg) {
		return restResult(null, 1, msg);
	}

	public static <T> R<T> failed(T data) {
		return restResult(data, 1, null);
	}

	public static <T> R<T> failed(T data, String msg) {
		return restResult(data, 1, msg);
	}

	private static <T> R<T> restResult(T data, int code, String msg) {
		R<T> apiResult = new R<>();
		apiResult.setCode(code);
		apiResult.setData(data);
		apiResult.setMsg(msg);
		return apiResult;
	}

}
