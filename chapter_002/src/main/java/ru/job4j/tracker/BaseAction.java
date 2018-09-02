package ru.job4j.tracker;
/**
 * Абстрактный класс для пунктов в MenuTracker.
 */
public abstract class BaseAction implements UserAction {
    /**
     * Пункт меню.
     */
    private final int key;
    /**
     * Описание пункта меню.
     */
    private final String name;
    /**
     * Конструтор инициализирующий поля.
     * @param key пункт меню.
     * @param name Описание пункта меню.
     */
    protected BaseAction(final int key, final String name) {
        this.key = key;
        this.name = name;
    }
    @Override
    public final int key() {
        return this.key;
    }
    @Override
    public final String info() {
        return String.format("%s. %s", this.key, this.name);
    }
}

