const BUY_BAT = 'BUY_BAT';
const SELL_BAT = 'SELL_BAT';

export const buyBat = (number = 1) => {
    return {
        type: BUY_BAT,
        payload: number
    }
}

export const sellBat = (number = 1) => {
    return {
        type: SELL_BAT,
        payload: number
    }
}