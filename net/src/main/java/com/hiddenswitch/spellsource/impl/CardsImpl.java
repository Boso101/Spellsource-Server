package com.hiddenswitch.spellsource.impl;

import co.paralleluniverse.fibers.SuspendExecution;
import co.paralleluniverse.fibers.Suspendable;
import com.hiddenswitch.spellsource.Cards;
import com.hiddenswitch.spellsource.util.Rpc;
import com.hiddenswitch.spellsource.util.Registration;
import com.hiddenswitch.spellsource.models.*;
import net.demilich.metastone.game.cards.*;
import net.demilich.metastone.game.cards.desc.CardDesc;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by bberman on 1/20/17.
 */
public class CardsImpl extends AbstractService<CardsImpl> implements Cards {
	private Random random = new Random();
	private Registration registration;

	@Override
	public void start() throws SuspendExecution {
		super.start();
		registration = Rpc.register(this, Cards.class, vertx.eventBus());
	}

	@Override
	@Suspendable
	public GetCardResponse getCard(GetCardRequest request) {
		return new GetCardResponse().withRecord(CardCatalogue.getRecords().get(request.getCardId()));
	}

	@Override
	@Suspendable
	public QueryCardsResponse queryCards(QueryCardsRequest request) throws SuspendExecution, InterruptedException {
		// For now, just use the CardCatalogue
		CardCatalogue.loadCardsFromPackage();

		final QueryCardsResponse response;

		if (request.isBatchRequest()) {
			response = new QueryCardsResponse()
					.withRecords(new ArrayList<>());

			for (QueryCardsRequest request1 : request.getRequests()) {
				response.append(this.queryCards(request1));
			}
		} else if (request.getCardIds() != null) {
			response = new QueryCardsResponse()
					.withRecords(request.getCardIds().stream().map(CardCatalogue.getRecords()::get).collect(Collectors.toList()));
		} else {
			final EnumSet<CardSet> sets = EnumSet.noneOf(CardSet.class);
			sets.addAll(Arrays.asList(request.getSets()));

			List<CardCatalogueRecord> results = CardCatalogue.getRecords().values().stream().filter(r -> {
				boolean passes = true;

				final CardDesc desc = r.getDesc();

				passes &= desc.collectible;
				passes &= sets.contains(desc.set);

				if (request.getRarity() != null) {
					passes &= desc.rarity.isRarity(request.getRarity());
				}

				return passes;
			}).collect(Collectors.toList());

			int count = results.size();

			if (request.isRandomCountRequest()) {
				Collections.shuffle(results, random);
				count = Math.min(request.getRandomCount(), count);
			}

			List<CardCatalogueRecord> cards = results;
			if (count != 0) {
				cards = new ArrayList<>(cards.subList(0, count));
			}

			response = new QueryCardsResponse()
					.withRecords(cards);
		}
		return response;
	}

	@Override
	@Suspendable
	public InsertCardResponse insertCard(InsertCardRequest request) {
		CardCatalogue.getRecords().put(request.getCard().getId(), request.getCard());
		return new InsertCardResponse();
	}

	@Override
	@Suspendable
	public UpdateCardResponse updateCard(UpdateCardRequest request) {
		insertCard(new InsertCardRequest().withCard(request.getCard()));
		return new UpdateCardResponse();
	}

	@Override
	@Suspendable
	public void stop() throws Exception {
		super.stop();
		Rpc.unregister(registration);
	}
}
