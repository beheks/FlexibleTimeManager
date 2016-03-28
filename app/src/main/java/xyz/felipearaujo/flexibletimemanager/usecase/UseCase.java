package xyz.felipearaujo.flexibletimemanager.usecase;

import rx.Observable;

public abstract class UseCase {
    protected abstract Observable buildUseCase();
}
