VTABLE(_Main) {
    <empty>
    Main
}

FUNCTION(_Main_New) {
memo ''
_Main_New:
    _T0 = 4
    parm _T0
    _T1 =  call _Alloc
    _T2 = VTBL <_Main>
    *(_T1 + 0) = _T2
    return _T1
}

FUNCTION(main) {
memo ''
main:
    _T4 = 1
    _T5 = 3
    _T6 = 0
    _T7 = (_T5 < _T6)
    if (_T7 == 0) branch _L10
    _T8 = "Decaf runtime error: The length of the created array should not be less than 0.\n"
    parm _T8
    call _PrintString
    call _Halt
_L10:
    _T9 = 4
    _T10 = (_T9 * _T5)
    _T11 = (_T9 + _T10)
    parm _T11
    _T12 =  call _Alloc
    *(_T12 + 0) = _T5
    _T13 = 0
    _T12 = (_T12 + _T11)
_L11:
    _T11 = (_T11 - _T9)
    if (_T11 == 0) branch _L12
    _T12 = (_T12 - _T9)
    *(_T12 + 0) = _T13
    branch _L11
_L12:
    _T14 = 4
    _T15 = _T12
    _T16 = (_T5 * _T14)
    _T17 = (_T12 + _T16)
_L13:
    _T18 = (_T15 < _T17)
    if (_T18 == 0) branch _L14
    *(_T15 + 0) = _T4
    _T19 = (_T15 + _T14)
    _T15 = _T19
    branch _L13
_L14:
    _T3 = _T12
    _T20 = 1
    _T21 = *(_T3 - 4)
    _T22 = (_T20 < _T21)
    if (_T22 == 0) branch _L15
    _T23 = 0
    _T24 = (_T20 < _T23)
    if (_T24 == 0) branch _L16
_L15:
    _T25 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T25
    call _PrintString
    call _Halt
_L16:
    _T26 = 4
    _T27 = (_T20 * _T26)
    _T28 = (_T3 + _T27)
    _T29 = *(_T28 + 0)
    _T30 = 0
    _T31 = 4
    _T32 = (_T20 * _T31)
    _T33 = (_T3 + _T32)
    *(_T33 + 0) = _T30
    _T34 = 0
    _T35 = *(_T3 - 4)
    _T36 = (_T34 < _T35)
    if (_T36 == 0) branch _L17
    _T37 = 0
    _T38 = (_T34 < _T37)
    if (_T38 == 0) branch _L18
_L17:
    _T39 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T39
    call _PrintString
    call _Halt
_L18:
    _T40 = 4
    _T41 = (_T34 * _T40)
    _T42 = (_T3 + _T41)
    _T43 = *(_T42 + 0)
    parm _T43
    call _PrintBool
    _T44 = "\n"
    parm _T44
    call _PrintString
    _T45 = 1
    _T46 = *(_T3 - 4)
    _T47 = (_T45 < _T46)
    if (_T47 == 0) branch _L19
    _T48 = 0
    _T49 = (_T45 < _T48)
    if (_T49 == 0) branch _L20
_L19:
    _T50 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T50
    call _PrintString
    call _Halt
_L20:
    _T51 = 4
    _T52 = (_T45 * _T51)
    _T53 = (_T3 + _T52)
    _T54 = *(_T53 + 0)
    parm _T54
    call _PrintBool
    _T55 = "\n"
    parm _T55
    call _PrintString
}

