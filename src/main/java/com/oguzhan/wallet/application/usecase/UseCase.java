package com.oguzhan.wallet.application.usecase;


public interface UseCase<Req, Res> {
    Res handle(Req req);
}