package ifml3.api.engine.entity;

import ifml3.api.engine.Component;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Story entity.
 */
public class Entity {

    private final UUID id;
    private final Map<Class<? extends Component>, Component> components;

    public Entity() {
        this(UUID.randomUUID());
    }

    public Entity(final UUID id) {
        this.id = id;
        this.components = new ConcurrentHashMap();
    }

    public UUID id() {
        return id;
    }

    public <C extends Component> boolean has(final Class<C> type) {
        return components.containsKey(type);
    }

    public <C extends Component> void put(final Class<C> type, final C value) {
        components.put(type, value);
    }

    public <C extends Component> C get(final Class<C> type) {
        return type.cast(components.get(type));
    }

    public <C extends Component> void remove(final Class<C> type) {
        components.remove(type);
    }
}
