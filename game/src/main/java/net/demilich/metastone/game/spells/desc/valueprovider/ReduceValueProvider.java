package net.demilich.metastone.game.spells.desc.valueprovider;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import co.paralleluniverse.fibers.Suspendable;
import net.demilich.metastone.game.utils.Attribute;
import net.demilich.metastone.game.GameContext;
import net.demilich.metastone.game.Player;
import net.demilich.metastone.game.entities.Entity;
import net.demilich.metastone.game.spells.desc.filter.EntityFilter;
import net.demilich.metastone.game.targeting.EntityReference;

public class ReduceValueProvider extends ValueProvider {
	public ReduceValueProvider(ValueProviderDesc desc) {
		super(desc);
	}

	public static ValueProviderDesc create(EntityReference target, Attribute attribute, EntityFilter filter, AlgebraicOperation operation) {
		Map<ValueProviderArg, Object> arguments = ValueProviderDesc.build(ReduceValueProvider.class);
		arguments.put(ValueProviderArg.TARGET, target);
		arguments.put(ValueProviderArg.FILTER, filter);
		arguments.put(ValueProviderArg.ATTRIBUTE, attribute);
		arguments.put(ValueProviderArg.OPERATION, operation);

		return new ValueProviderDesc(arguments);
	}

	public static ValueProviderDesc create(EntityReference target, ValueProviderDesc value1, EntityFilter filter, AlgebraicOperation operation) {
		Map<ValueProviderArg, Object> arguments = ValueProviderDesc.build(ReduceValueProvider.class);
		arguments.put(ValueProviderArg.TARGET, target);
		arguments.put(ValueProviderArg.FILTER, filter);
		arguments.put(ValueProviderArg.VALUE1, value1.create());
		arguments.put(ValueProviderArg.OPERATION, operation);
		return new ValueProviderDesc(arguments);
	}

	@Override
	@Suspendable
	protected int provideValue(GameContext context, Player player, Entity target, Entity host) {
		EntityReference sourceReference = (EntityReference) desc.get(ValueProviderArg.TARGET);
		Attribute attribute = (Attribute) desc.get(ValueProviderArg.ATTRIBUTE);
		List<Entity> entities = null;
		if (sourceReference != null) {
			entities = context.resolveTarget(player, host, sourceReference);
		} else {
			entities = new ArrayList<>();
			entities.add(target);
		}
		if (entities == null) {
			return 0;
		}

		AlgebraicOperation operation = desc.containsKey(ValueProviderArg.OPERATION) ?
				(AlgebraicOperation) desc.get(ValueProviderArg.OPERATION)
				: AlgebraicOperation.MAXIMUM;


		EntityFilter filter = (EntityFilter) desc.get(ValueProviderArg.FILTER);
		int value;

		if (operation == AlgebraicOperation.MAXIMUM) {
			value = Integer.MIN_VALUE;
		} else if (operation == AlgebraicOperation.MINIMUM) {
			value = Integer.MAX_VALUE;
		} else if (operation == AlgebraicOperation.MULTIPLY) {
			value = 1;
		} else if (operation == AlgebraicOperation.DIVIDE
				|| operation == AlgebraicOperation.MODULO
				|| operation == AlgebraicOperation.NEGATE) {
			throw new UnsupportedOperationException("Cannot (or ill-advised) to do a reduce with a DIVIDE, MODULO or NEGATE operator.");
		} else {
			value = 0;
		}

		for (Entity entity : entities) {
			if (filter != null && !filter.matches(context, player, entity, host)) {
				continue;
			}

			boolean isApplyingValueProvider = desc.containsKey(ValueProviderArg.VALUE1) &&
					ValueProvider.class.isAssignableFrom(desc.get(ValueProviderArg.VALUE1).getClass());
			if (isApplyingValueProvider) {
				ValueProvider targetValueProvider = (ValueProvider) desc.get(ValueProviderArg.VALUE1);
				value = operation.performOperation(value, targetValueProvider.getValue(context, player, entity, target));
			} else if (attribute != null) {
				int value1 = AttributeValueProvider.create(attribute, entity.getReference()).create().getValue(context, player, entity, host);
				value = operation.performOperation(value, value1);
			} else {
				value = operation.performOperation(value, desc.getInt(ValueProviderArg.VALUE1));
			}

		}

		return value;
	}

}
