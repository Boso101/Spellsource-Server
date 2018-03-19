package net.demilich.metastone.game.spells.desc.source;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import net.demilich.metastone.game.cards.desc.Desc;
import net.demilich.metastone.game.cards.desc.CardSourceDescDeserializer;

import java.util.Map;

@JsonDeserialize(using = CardSourceDescDeserializer.class)
public class CardSourceDesc extends Desc<CardSourceArg, CardSource> {

	public CardSourceDesc() {
		super();
	}

	public CardSourceDesc(Class<? extends CardSource> cardSourceClass) {
		super(cardSourceClass);
	}

	public CardSourceDesc(Map<CardSourceArg, Object> arguments) {
		super(arguments);
	}

	@Override
	protected Class<? extends Desc> getDescImplClass() {
		return CardSourceDesc.class;
	}

	@Override
	public CardSourceArg getClassArg() {
		return CardSourceArg.CLASS;
	}

	@Override
	public CardSourceDesc clone() {
		return (CardSourceDesc) copyTo(new CardSourceDesc(getDescClass()));
	}
}
