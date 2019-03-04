package com.zomu.t.epion.tropic.test.tool.epiont3targetapprest.app.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class AspectLog {

	@Around("within(com.zomu.t.epion.tropic.test.tool.epiont3targetapprest.app.controller.TodosController) ||"
			+ "within(com.zomu.t.epion.tropic.test.tool.epiont3targetapprest.domain.service.TodoCrudService)")
	public Object around(ProceedingJoinPoint pj) throws Throwable {
        if (pj instanceof MethodInvocationProceedingJoinPoint) {
            // メソッドに対するアノテーションのみをここで処理する
        	Signature sig = pj.getSignature();
        	String methodName = sig.getDeclaringType().getSimpleName() + "#" + sig.getName();
            // 開始終了ログ＋本処理実行
            return loggingAndProceed(pj, methodName);
        } else {
            return pj.proceed();
        }
    }
	
	/**
     * 開始終了ログ、本処理実行処理
     *
     * @param pj
     * @param methodName
     *            メソッド名
     * @return 処理結果
     * @throws Throwable
     *             例外全般
     */
    private Object loggingAndProceed(ProceedingJoinPoint pj, String methodName)
            throws Throwable {
        long start = 0;
        try {
            // 開始ログ出力
            log.info("{} stared.", methodName);
            // 処理開始時取得
            start = System.currentTimeMillis();
            // 本処理
            return pj.proceed();
        } catch (Throwable e) {
            // 異常終了ログ
            log.info("{} fail.", methodName);
            throw e;
        } finally {
            // 処理時間計測
            long processingTime = System.currentTimeMillis() - start;
            // 終了ログ出力
            log.info("{} finished. {} milisec.", methodName,
                    String.valueOf(processingTime));
        }
    }
}
