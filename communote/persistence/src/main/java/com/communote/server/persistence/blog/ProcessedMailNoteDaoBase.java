package com.communote.server.persistence.blog;

/**
 * <p>
 * Base Spring DAO Class: is able to create, update, remove, load, and find objects of type
 * <code>com.communote.server.persistence.blog.ProcessedMailNote</code>.
 * </p>
 * 
 * @see com.communote.server.model.note.ProcessedMailNote
 * @author Communote GmbH - <a href="http://www.communote.com/">http://www.communote.com/</a>
 */
public abstract class ProcessedMailNoteDaoBase extends
        org.springframework.orm.hibernate3.support.HibernateDaoSupport implements
        com.communote.server.persistence.blog.ProcessedMailNoteDao {

    /**
     * @see com.communote.server.persistence.blog.ProcessedMailNoteDao#create(com.communote.server.model.note.ProcessedMailNote)
     */
    public com.communote.server.model.note.ProcessedMailNote create(
            com.communote.server.model.note.ProcessedMailNote processedMailNote) {
        return (com.communote.server.model.note.ProcessedMailNote) this.create(TRANSFORM_NONE,
                processedMailNote);
    }

    /**
     * @see com.communote.server.persistence.blog.ProcessedMailNoteDao#create(int transform,
     *      com.communote.server.persistence.blog.ProcessedMailNote)
     */
    public Object create(final int transform,
            final com.communote.server.model.note.ProcessedMailNote processedMailNote) {
        if (processedMailNote == null) {
            throw new IllegalArgumentException(
                    "ProcessedMailNote.create - 'processedMailNote' can not be null");
        }
        this.getHibernateTemplate().save(processedMailNote);
        return this.transformEntity(transform, processedMailNote);
    }

    /**
     * @see com.communote.server.persistence.blog.ProcessedMailNoteDao#create(int,
     *      java.util.Collection<com.communote.server.persistence.blog.ProcessedMailNote>)
     */
    public java.util.Collection<com.communote.server.model.note.ProcessedMailNote> create(
            final int transform,
            final java.util.Collection<com.communote.server.model.note.ProcessedMailNote> entities) {
        if (entities == null) {
            throw new IllegalArgumentException(
                    "ProcessedMailNote.create - 'entities' can not be null");
        }
        this.getHibernateTemplate()
                .executeWithNativeSession(
                        new org.springframework.orm.hibernate3.HibernateCallback<com.communote.server.model.note.ProcessedMailNote>() {
                            public com.communote.server.model.note.ProcessedMailNote doInHibernate(
                                    org.hibernate.Session session)
                                    throws org.hibernate.HibernateException {
                                for (java.util.Iterator<com.communote.server.model.note.ProcessedMailNote> entityIterator = entities
                                        .iterator(); entityIterator.hasNext();) {
                                    create(transform, entityIterator.next());
                                }
                                return null;
                            }
                        });
        return entities;
    }

    /**
     * @see 
     *      com.communote.server.persistence.blog.ProcessedMailNoteDao#create(java.util.Collection<de
     *      .communardo.kenmei.core.api.bo.blog.ProcessedMailNote>)
     */
    @SuppressWarnings({ "unchecked" })
    public java.util.Collection<com.communote.server.model.note.ProcessedMailNote> create(
            final java.util.Collection<com.communote.server.model.note.ProcessedMailNote> entities) {
        return (java.util.Collection<com.communote.server.model.note.ProcessedMailNote>) create(
                TRANSFORM_NONE, entities);
    }

    /**
     * {@inheritDoc}
     */
    public void evict(com.communote.server.model.note.ProcessedMailNote entity) {
        this.getHibernateTemplate().evict(entity);
    }

    /**
     * @see com.communote.server.persistence.blog.ProcessedMailNoteDao#findByMailMessageId(String)
     */
    public com.communote.server.model.note.ProcessedMailNote findByMailMessageId(
            final String mailMessageId) {
        if (mailMessageId == null) {
            throw new IllegalArgumentException(
                    "com.communote.server.persistence.blog.ProcessedMailNoteDao.findByMailMessageId(String mailMessageId) - 'mailMessageId' can not be null");
        }
        try {
            return this.handleFindByMailMessageId(mailMessageId);
        } catch (RuntimeException rt) {
            throw new RuntimeException(
                    "Error performing 'com.communote.server.persistence.blog.ProcessedMailNoteDao.findByMailMessageId(String mailMessageId)' --> "
                            + rt, rt);
        }
    }

    /**
     * Performs the core logic for {@link #findByMailMessageId(String)}
     */
    protected abstract com.communote.server.model.note.ProcessedMailNote handleFindByMailMessageId(
            String mailMessageId);

    /**
     * @see com.communote.server.persistence.blog.ProcessedMailNoteDao#load(int, Long)
     */
    public Object load(final int transform, final Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ProcessedMailNote.load - 'id' can not be null");
        }
        final Object entity = this.getHibernateTemplate().get(
                com.communote.server.model.note.ProcessedMailNoteImpl.class, id);
        return transformEntity(transform,
                (com.communote.server.model.note.ProcessedMailNote) entity);
    }

    /**
     * @see com.communote.server.persistence.blog.ProcessedMailNoteDao#load(Long)
     */
    public com.communote.server.model.note.ProcessedMailNote load(Long id) {
        return (com.communote.server.model.note.ProcessedMailNote) this.load(TRANSFORM_NONE, id);
    }

    /**
     * @see com.communote.server.persistence.blog.ProcessedMailNoteDao#loadAll()
     */
    @SuppressWarnings({ "unchecked" })
    public java.util.Collection<com.communote.server.model.note.ProcessedMailNote> loadAll() {
        return (java.util.Collection<com.communote.server.model.note.ProcessedMailNote>) this
                .loadAll(TRANSFORM_NONE);
    }

    /**
     * @see com.communote.server.persistence.blog.ProcessedMailNoteDao#loadAll(int)
     */
    public java.util.Collection<?> loadAll(final int transform) {
        final java.util.Collection<?> results = this.getHibernateTemplate().loadAll(
                com.communote.server.model.note.ProcessedMailNoteImpl.class);
        this.transformEntities(transform, results);
        return results;
    }

    /**
     * @see com.communote.server.persistence.blog.ProcessedMailNoteDao#remove(com.communote.server.model.note.ProcessedMailNote)
     */
    public void remove(com.communote.server.model.note.ProcessedMailNote processedMailNote) {
        if (processedMailNote == null) {
            throw new IllegalArgumentException(
                    "ProcessedMailNote.remove - 'processedMailNote' can not be null");
        }
        this.getHibernateTemplate().delete(processedMailNote);
    }

    /**
     * @see 
     *      com.communote.server.persistence.blog.ProcessedMailNoteDao#remove(java.util.Collection<de
     *      .communardo.kenmei.core.api.bo.blog.ProcessedMailNote>)
     */
    public void remove(
            java.util.Collection<com.communote.server.model.note.ProcessedMailNote> entities) {
        if (entities == null) {
            throw new IllegalArgumentException(
                    "ProcessedMailNote.remove - 'entities' can not be null");
        }
        this.getHibernateTemplate().deleteAll(entities);
    }

    /**
     * @see com.communote.server.persistence.blog.ProcessedMailNoteDao#remove(Long)
     */
    public void remove(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ProcessedMailNote.remove - 'id' can not be null");
        }
        com.communote.server.model.note.ProcessedMailNote entity = this.load(id);
        if (entity != null) {
            this.remove(entity);
        }
    }

    /**
     * Transforms a collection of entities using the
     * {@link #transformEntity(int,com.communote.server.model.note.ProcessedMailNote)} method. This
     * method does not instantiate a new collection.
     * <p/>
     * This method is to be used internally only.
     * 
     * @param transform
     *            one of the constants declared in
     *            <code>com.communote.server.persistence.blog.ProcessedMailNoteDao</code>
     * @param entities
     *            the collection of entities to transform
     * @see #transformEntity(int,com.communote.server.model.note.ProcessedMailNote)
     */
    protected void transformEntities(final int transform, final java.util.Collection<?> entities) {
        switch (transform) {
        case TRANSFORM_NONE: // fall-through
        default:
            // do nothing;
        }
    }

    /**
     * Allows transformation of entities into value objects (or something else for that matter),
     * when the <code>transform</code> flag is set to one of the constants defined in
     * <code>com.communote.server.persistence.blog.ProcessedMailNoteDao</code>, please note that the
     * {@link #TRANSFORM_NONE} constant denotes no transformation, so the entity itself will be
     * returned.
     * 
     * If the integer argument value is unknown {@link #TRANSFORM_NONE} is assumed.
     * 
     * @param transform
     *            one of the constants declared in
     *            {@link com.communote.server.persistence.blog.ProcessedMailNoteDao}
     * @param entity
     *            an entity that was found
     * @return the transformed entity (i.e. new value object, etc)
     * @see #transformEntities(int,java.util.Collection)
     */
    protected Object transformEntity(final int transform,
            final com.communote.server.model.note.ProcessedMailNote entity) {
        Object target = null;
        if (entity != null) {
            switch (transform) {
            case TRANSFORM_NONE: // fall-through
            default:
                target = entity;
            }
        }
        return target;
    }

    /**
     * @see com.communote.server.persistence.blog.ProcessedMailNoteDao#update(com.communote.server.model.note.ProcessedMailNote)
     */
    public void update(com.communote.server.model.note.ProcessedMailNote processedMailNote) {
        if (processedMailNote == null) {
            throw new IllegalArgumentException(
                    "ProcessedMailNote.update - 'processedMailNote' can not be null");
        }
        this.getHibernateTemplate().update(processedMailNote);
    }

    /**
     * @see 
     *      com.communote.server.persistence.blog.ProcessedMailNoteDao#update(java.util.Collection<de
     *      .communardo.kenmei.core.api.bo.blog.ProcessedMailNote>)
     */
    public void update(
            final java.util.Collection<com.communote.server.model.note.ProcessedMailNote> entities) {
        if (entities == null) {
            throw new IllegalArgumentException(
                    "ProcessedMailNote.update - 'entities' can not be null");
        }
        this.getHibernateTemplate()
                .executeWithNativeSession(
                        new org.springframework.orm.hibernate3.HibernateCallback<com.communote.server.model.note.ProcessedMailNote>() {
                            public com.communote.server.model.note.ProcessedMailNote doInHibernate(
                                    org.hibernate.Session session)
                                    throws org.hibernate.HibernateException {
                                for (java.util.Iterator<com.communote.server.model.note.ProcessedMailNote> entityIterator = entities
                                        .iterator(); entityIterator.hasNext();) {
                                    update(entityIterator.next());
                                }
                                return null;
                            }
                        });
    }

}