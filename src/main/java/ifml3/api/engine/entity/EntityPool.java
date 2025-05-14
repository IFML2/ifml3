package ifml3.api.engine.entity;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Entites.
 */
public class EntityPool {

    private final Map<UUID, Entity> entities;

    public EntityPool() {
        entities = new ConcurrentHashMap<>();
    }

    public void add(final Entity entity) {
        entities.put(entity.id(), entity);
    }

    public Entity findById(final UUID id) {
        return entities.get(id);
    }

    public Collection<Entity> findAll() {
        return entities.values();
    }
}
